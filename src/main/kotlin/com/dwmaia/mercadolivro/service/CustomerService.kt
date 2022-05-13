package com.dwmaia.mercadolivro.service

import com.dwmaia.mercadolivro.controller.request.PostCustomerDTO
import com.dwmaia.mercadolivro.controller.request.PutCustomerDTO
import com.dwmaia.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter {
                it.name!!.contains(name, true)
            }
        }
        return customers
    }

    fun getCustomer(id: Int): CustomerModel {
        return customers.filter { it.id == id }.first()
    }


    fun update(id: Int, request: CustomerModel) {
        customers.filter { it.id == id }.first().let {
            it.email = request.email
        }
    }

    fun create(request: CustomerModel) {
        println(request)
        customers.add( CustomerModel(
                name = request.name,
                email = request.email
        ) )
    }


    fun delete(id: Int) {
        customers.removeIf { it.id == id };
    }

  /*  private fun generationId(): Int {
        var id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }
        return id
    }
*/

}