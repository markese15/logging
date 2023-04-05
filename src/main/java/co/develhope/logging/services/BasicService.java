package co.develhope.logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {
    Logger logger= LoggerFactory.getLogger(BasicService.class);
    public int getCalculation(int a,int b) {
           logger.info("Start logger");
            int result = a + b ;
            logger.info("End logger");
            return result;
        }
}
