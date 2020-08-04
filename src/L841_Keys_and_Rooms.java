import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L841_Keys_and_Rooms {
    /**
     * time: O(v)
     * space: O(n)
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet();
        visited.add(0);
        dfs(rooms, visited, rooms.get(0));
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, List<Integer> keys){
        for(int key : keys){
            if(visited.contains(key)) continue;
            visited.add(key);
            dfs(rooms, visited, rooms.get(key));
        }
    }
}
