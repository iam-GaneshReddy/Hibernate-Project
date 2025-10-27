package com.scaleupindia.repository;

import com.scaleupindia.entity.Owner;

public interface OwnerRepository {
	void saveOwner(Owner owner);

	Owner findOwner(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteOwner(int ownerId);

}
