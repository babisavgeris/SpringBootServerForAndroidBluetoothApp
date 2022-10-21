package com.babis.BluetoothServer;

import com.babis.BluetoothServer.entity.BluetoothData;
import com.babis.BluetoothServer.entity.Role;
import com.babis.BluetoothServer.entity.User;
import com.babis.BluetoothServer.service.BluetoothDataService;
import com.babis.BluetoothServer.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class BluetoothServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluetoothServerApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/**@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));

			//userService	.saveUser(new User(null,"John Travolta", "john", "1234", new ArrayList<>()));
			//userService	.saveUser(new User(null,"Will Smith", "will", "111", new ArrayList<>()));
			//userService	.saveUser(new User(null,"Jim Carry", "jim", "1234", new ArrayList<>()));

			//userService	.saveUser(new User(null,"john", "1234", new ArrayList<>(),new ArrayList<>()));
			//userService	.saveUser(new User(null,"will", "111", new ArrayList<>(),new ArrayList<>()));
			//userService	.saveUser(new User(null,"jim", "1234", new ArrayList<>(),new ArrayList<>()));

			//userService.addRoleToUser("john", "ROLE_USER");
			//userService.addRoleToUser("will", "ROLE_USER");
			//userService.addRoleToUser("jim", "ROLE_USER");

		};
	}

	@Bean
	CommandLineRunner runner(BluetoothDataService bluetoothDataService, UserService userService){
		return args -> {
			for (int i=0; i<10; i++){
				bluetoothDataService.saveData(new BluetoothData(i+15,23.727539,37.98381 ,"Athens","Greece",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+14,-3.70379,40.416775 ,"Madrid","Spain",
						userService.getUser("maria")));
				bluetoothDataService.saveData(new BluetoothData(i+13,11.576124 ,48.137154  ,"Munich","Germany",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+12,9.18854 ,45.464664  ,"Milan","Italy",
						userService.getUser("will")));
			}

			for (int i =0; i<5; i++){
				bluetoothDataService.saveData(new BluetoothData(i+4,21.734573,38.246639,"Patra","Greece",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+8,2.168365,41.346176,"Barcelona","Spain",
						userService.getUser("maria")));
				bluetoothDataService.saveData(new BluetoothData(i+5,6.983333,51.033333,"Leverkusen","Germany",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+7,14.305573,40.853294,"Napoli","Italy",
						userService.getUser("will")));
			}
			for (int i =0; i<7; i++){
				bluetoothDataService.saveData(new BluetoothData(i+12,22.114401,37.036598,"Kalamata","Greece",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+17,-0.375,39.466667,"Valencia","Spain",
						userService.getUser("maria")));
				bluetoothDataService.saveData(new BluetoothData(i+7,13.381777,52.520008,"Berlin","Germany",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+9,12.496366 ,41.902782,"Rome","Italy",
						userService.getUser("will")));
			}

			for (int i =0; i<7; i++){
				bluetoothDataService.saveData(new BluetoothData(i+7,22.933332 ,39.366669 ,"Volos","Greece",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+6,37.392529,-5.994072,"Sevilla","Spain",
						userService.getUser("maria")));
				bluetoothDataService.saveData(new BluetoothData(i+14,9.993682,53.551086,"Hamburg","Germany",
						userService.getUser("babis")));
				bluetoothDataService.saveData(new BluetoothData(i+20,12.496366 ,41.902782,"Rome","Italy",
						userService.getUser("will")));
			}

		};
	}**/


}
