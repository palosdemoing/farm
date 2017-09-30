package com.pal.farm.controller;

import com.pal.farm.dto.MessageDTO;

public interface ErrorController {

	MessageDTO errorNotFound(Exception e);

	MessageDTO errorCannotProceed(Exception e);

	MessageDTO errorGetArgs(Exception e);

	MessageDTO errorAssociation(Exception e);

}
