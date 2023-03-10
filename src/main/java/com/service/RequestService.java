package com.service;

import com.model.RequestItem;

import java.util.List;

public interface RequestService  {
    List<RequestItem> getReqname();
    RequestItem create(RequestItem name);
    //    void insert(RequestItem user);
//    RequestItem check(RequestItem exists)
    RequestItem getReqId(int id);
    RequestItem updateReq(RequestItem name);
    RequestItem deleteReq(int id);
}
