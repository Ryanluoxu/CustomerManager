package io.ryanluoxu.customerManager.service;

import io.ryanluoxu.customerManager.bean.entity.AuditTrail;

public interface AuditTrailService extends BaseService<AuditTrail, Long> {
	AuditTrail add(String actionType, String action);
}
