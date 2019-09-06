package com.note.myConcurrent.ProducerConsumer;

/**
 * @Classname Producer
 * @Date 2019-08-12 11:30
 * @Created by chenpan
 * @Description 生产者
 */
public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    String poemStr = "床前明月光，疑似地上霜。举头望明月，低头思故乡";
    String poemStrs[] = poemStr.split("[，。]");
    @Override
    public void run() {
        int i = 0;
        for (int j = 0; j < poemStrs.length; j++) {
            drop.put(poemStrs[i++]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("DONE");

    }
}
