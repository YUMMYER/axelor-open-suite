/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2018 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.sale.service.config;

import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.service.app.AppBaseServiceImpl;
import com.axelor.apps.sale.db.SaleConfig;
import com.axelor.apps.sale.exception.IExceptionMessage;
import com.axelor.exception.AxelorException;
import com.axelor.exception.db.IException;
import com.axelor.i18n.I18n;

public class SaleConfigServiceImpl implements SaleConfigService {
	
	
	public SaleConfig getSaleConfig(Company company) throws AxelorException  {
		
		SaleConfig saleConfig = company.getSaleConfig();
		
		if(saleConfig == null)  {
			throw new AxelorException(company, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.SALE_CONFIG_1), AppBaseServiceImpl.EXCEPTION, company.getName());
		}
		
		return saleConfig;
		
	}
	
	
	
	
}
