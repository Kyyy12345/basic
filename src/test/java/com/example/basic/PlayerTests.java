package com.example.basic;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.Player;
import com.example.basic.entity.Team;
import com.example.basic.repository.PlayerRepository;


import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PlayerTests {
	@Autowired PlayerRepository pr;

	@Test
	void playerSelect() {
		// 1번 선수의 팀 이름 조회
		Optional<Player> opt = pr.findById(1);
		Player player = opt.get();
		Team team = player.getTeam();
		String teamName = team.getTeamName();
		String teamName2 = pr.findById(1).get().getTeam().getTeamName();
		log.info(teamName);
		System.out.println(teamName.toString());
	}

	

}
