package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.AuditTrail;

public interface AuditTrailService {
	AuditTrail add(AuditTrail auditTrail);
	AuditTrail add(String actionType, String action);
	List<AuditTrail> findAll();
	AuditTrail getById(Long productInfoId);
}
