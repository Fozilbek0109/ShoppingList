package uz.coder.shoppinglist.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import uz.coder.shoppinglist.domain.entity.ShopItem
import uz.coder.shoppinglist.domain.use_case.AddShopItemUseCase
import uz.coder.shoppinglist.domain.use_case.EditShopItemUseCase
import uz.coder.shoppinglist.domain.use_case.GetShopItemByIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class ShopItemViewModel @Inject constructor(
    val addShopItemUseCase: AddShopItemUseCase,
    val editShopItemUseCase: EditShopItemUseCase,
    val getShopItemByIdUseCase: GetShopItemByIdUseCase
) : ViewModel() {



    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName


    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount


    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem


    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    public fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseString(inputName)
        val count = parseCount(inputCount)
        val validateInput = validateInput(name, count)
        if (validateInput) {
            val item = ShopItem(0, name, count, true)
            addShopItemUseCase(item)
            finishWork()
        }
    }


    public fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseString(inputName)
        val count = parseCount(inputCount)
        val validateInput = validateInput(name, count)
        if (validateInput) {

            _shopItem.value?.let {
                val item = it.copy(name = name, count = count)
                editShopItemUseCase(item)
                finishWork()
            }
        }
    }

    public fun getShopById(id: Int) {
        viewModelScope.launch {
            val item = getShopItemByIdUseCase(id)
            _shopItem.value = item!!
        }
    }

    private fun parseString(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    public fun resetInputNameError() {
        _errorInputName.value = false
    }

    public fun resetInputCountError() {
        _errorInputCount.value = false
    }

    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }

}