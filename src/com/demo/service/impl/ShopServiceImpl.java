package com.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.base.DaoSupportImpl;
import com.demo.domain.Shop;
import com.demo.service.ShopService;

@Service
@Transactional
public class ShopServiceImpl extends DaoSupportImpl<Shop> implements
		ShopService {

}
