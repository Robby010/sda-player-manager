package com.sda.player_manager;

import java.util.Date;
import lombok.Data;

@Data
public class Player {

	private int id;
	private String accountName;
	private String firstName;
	private String lastName;
	private Date birthDate;
}
