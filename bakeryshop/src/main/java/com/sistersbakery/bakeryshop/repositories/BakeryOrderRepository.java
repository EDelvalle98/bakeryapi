package com.sistersbakery.bakeryshop.repositories;

import com.sistersbakery.bakeryshop.model.BakeryOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryOrderRepository extends CrudRepository<BakeryOrder, Long> {

}
