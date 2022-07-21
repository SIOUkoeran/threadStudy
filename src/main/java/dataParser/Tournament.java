package dataParser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tournament {
    private List<Player> players = new LinkedList<Player>();

    public synchronized void addPlayer(Player p){
        players.add(p);
    }

    /**\
     * iterator 가 players의 내부에 저장된 가변상태 참조할 수 있음.
     * 함수형 (람다) 사용으로 해당 가변 상태 참조 상황을 피하자.
     * ConcurrentModificationException
     * @return
     */
    public synchronized Iterator<Player> getPlayerIterator(){
        return players.iterator();
    }
}
