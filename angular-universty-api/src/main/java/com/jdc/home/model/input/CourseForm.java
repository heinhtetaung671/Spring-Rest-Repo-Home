package com.jdc.home.model.input;

import com.jdc.home.model.entity.Category;

public record CourseForm(String name, Category category, int fees, int duration, String description) {

}
