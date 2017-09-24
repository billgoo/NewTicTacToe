public class Game {
	public int getSize = 0;
    /**
     * Game的接口方法，我们会通过该方法进行测试
     * @param gameMode为游戏模式,有四种可能，00,01,10,11
     * @param moveStr为落子序列
     * @param size棋盘大小，size最小为3， 最大为9
     * @return 游戏结果
     */
	/*
	 * 请修改该方法
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
    		// 游戏结束
    		if( !res.equals(Result.GAMING) )
    			break;
    	}
    	return res;
    }
}
