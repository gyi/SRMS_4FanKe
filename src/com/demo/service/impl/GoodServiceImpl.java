package com.demo.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.base.DaoSupportImpl;
import com.demo.domain.Good;
import com.demo.service.GoodService;

@Service
@Transactional
@Repository
public class GoodServiceImpl extends DaoSupportImpl<Good> implements
		GoodService {

}
