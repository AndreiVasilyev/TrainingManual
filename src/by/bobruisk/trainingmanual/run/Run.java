package by.bobruisk.trainingmanual.run;


import org.apache.log4j.Logger;

import by.bobruisk.trainingmanual.data.TrainingManualRealisation;


public class Run {
	
	private final static Logger LOGGER = Logger.getLogger(Run.class);
	
	public static void main(String[] args)  {
		LOGGER.info("run application");
		new TrainingManualRealisation();

	}

}
