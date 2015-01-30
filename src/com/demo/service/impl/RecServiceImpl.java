package com.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.base.DaoSupportImpl;
import com.demo.domain.Rec;
import com.demo.service.RecService;

@Service
@Transactional
public class RecServiceImpl extends DaoSupportImpl<Rec> implements RecService {



}
