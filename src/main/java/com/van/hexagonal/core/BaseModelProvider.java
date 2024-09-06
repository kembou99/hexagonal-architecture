package com.van.hexagonal.core;

import java.util.List;
import java.util.Optional;

public interface BaseModelProvider<Model,T>{

     Model save(Model model);
     Optional<Model> get(T modelId);
     List<Model> getAll();
     List<Model> search(Model model);

}
