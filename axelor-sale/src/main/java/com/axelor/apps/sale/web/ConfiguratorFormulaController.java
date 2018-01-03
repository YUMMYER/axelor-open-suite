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
package com.axelor.apps.sale.web;

import com.axelor.apps.sale.db.ConfiguratorCreator;
import com.axelor.apps.sale.db.ConfiguratorFormula;
import com.axelor.apps.sale.db.repo.ConfiguratorFormulaRepository;
import com.axelor.apps.sale.exception.IExceptionMessage;
import com.axelor.apps.sale.service.ConfiguratorFormulaService;
import com.axelor.exception.AxelorException;
import com.axelor.i18n.I18n;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class ConfiguratorFormulaController {

    private ConfiguratorFormulaService configuratorFormulaService;
    private ConfiguratorFormulaRepository configuratorFormulaRepository;

    @Inject
    public ConfiguratorFormulaController(ConfiguratorFormulaService configuratorFormulaService, ConfiguratorFormulaRepository configuratorFormulaRepository) {
        this.configuratorFormulaService = configuratorFormulaService;
        this.configuratorFormulaRepository = configuratorFormulaRepository;
    }


    /**
     * Check the groovy script in the context
     * @param request
     * @param response
     */
    public void checkGroovyFormula(ActionRequest request, ActionResponse response) {
        ConfiguratorFormula configuratorFormula = request.getContext().asType(ConfiguratorFormula.class);
        ConfiguratorCreator creator = request.getContext().getParent().asType(ConfiguratorCreator.class);
        try {
            configuratorFormula = configuratorFormulaRepository.find(configuratorFormula.getId());
            configuratorFormulaService.checkFormula(configuratorFormula, creator);
            response.setAlert(I18n.get(IExceptionMessage.CONFIGURATOR_CREATOR_SCRIPT_WORKING));
        } catch (AxelorException e) {
            response.setError(e.getMessage());
        }
    }
}
