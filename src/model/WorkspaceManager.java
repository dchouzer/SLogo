package model;

import java.util.HashMap;
import java.util.Map;

public class WorkspaceManager {
	private Map<Integer, Workspace> workspaceMap;
	private int workspaceId = 0;
	private int activeWorkspace;
	
	public WorkspaceManager() {
		workspaceMap = new HashMap<Integer, Workspace>();
	}
	
	public int addNewWorkspace() {
		int newId = workspaceId;
		activeWorkspace = newId;
		workspaceMap.put(newId, new Workspace());
		workspaceId++;
		return newId;
	}
	
	public Workspace getWorkspace(int id) {
		return workspaceMap.get(id);
	}
	
	public Workspace getActiveWorkspace() {
		return getWorkspace(activeWorkspace);
	}
	
	public Workspace switchWorkspace(int id) {
		activeWorkspace = id;
		return getActiveWorkspace();
	}
}
