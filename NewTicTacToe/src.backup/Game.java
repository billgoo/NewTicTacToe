public class Game {
    /**
     * Game�Ľӿڷ��������ǻ�ͨ���÷������в���
     * @param gameModeΪ��Ϸģʽ,�����ֿ��ܣ�00,01,10,11
     * @param moveStrΪ��������
     * @param size���̴�С��size��СΪ3�� ���Ϊ9
     * @return ��Ϸ���
     */
	/*
	 * ���޸ĸ÷���
	 */
    public Result playGame(String gameMode, String moveStr, int size){
    	Board board = new Board();
    	
    	String[] moves = moveStr.split(",");
    	Result res = Result.GAMING;
    	for(String move: moves){
    		res = board.nextMove(move);
    		board.print();
    		// ��Ϸ����
    		if( !res.equals(Result.GAMING) )
    			break;
    	}
    	return res;
    }
}
