package com.scaleupindia.service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exceptions.OwnerAlreadyExistsException;
import com.scaleupindia.exceptions.OwnerNotFoundException;

public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws OwnerAlreadyExistsException;

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;

}
