package com.gestion.dao;

import java.util.List;

import com.base.donnees.Agentdescolarite;


public interface IAgentdescolariteDao {
	
	 void saveAgent(Agentdescolarite agent);

	 List<Agentdescolarite> getAllAgents();

	 void SupprimerAgent(int id);
	 
	 Agentdescolarite getAgentScoById(int id);
}
