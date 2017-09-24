public class Game {
	public int getSize = 0;
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

    	GameChessStrategy gameChessStrategy = new GameChessStrategy();
    	GameChessStrategyFive gameChessStrategyFive = new GameChessStrategyFive();

    	GameWinStrategy_HV gameWinStrategy_hv = new GameWinStrategy_HV();
		GameWinStrategy_HVD gameWinStrategy_hvd = new GameWinStrategy_HVD();

		Board board = null;

		getSize = size;

    	switch (gameMode){
			case "00":
				board = new Board(size,gameChessStrategy,gameWinStrategy_hvd);
				break;
			case "01":
				board = new Board(size,gameChessStrategy,gameWinStrategy_hv);
				break;
			case "10":
				board = new Board(size,gameChessStrategyFive,gameWinStrategy_hvd);
				break;
			case "11":
				board = new Board(size,gameChessStrategyFive,gameWinStrategy_hv);
				break;
			default:
				board = new Board();
				break;
		}
    	// Board board = new Board();
    	
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
