package com.shoppi.app.repository.category

import com.shoppi.app.model.Category

interface CategoryDateSource {

    suspend fun getCategories():List<Category>
}