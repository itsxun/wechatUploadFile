package xin.fallen.listerner;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import xin.fallen.util.PropReader;

/**
 * Author: fallen
 * Date: 17-2-14
 * Time: 上午9:45
 * Usage:
 */
public class SpringReadyLis implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent e) {
        PropReader.propInit();
    }
}