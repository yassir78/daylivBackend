package com.dayliv.dayliv.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dispatcher")
public class Dispatcher extends User {

}
