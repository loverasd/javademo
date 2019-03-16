package com.note.design_patterns.builder.builder1;

/**
 * @program: javademo
 * @description: 替代多参构造方法--建造者模式
 * @author: chenp
 * @create: 2019-02-20 17:45
 **/

public class Computer {

    private String mainBoard;     // 主板
    private String cpu;           // cpu
    private String hd;            // 硬盘
    private String powerSupplier; // 电源
    private String graphicsCard;   // 显卡

    // 其它一些可选配置
    private String mouse; // 鼠标
    private String computerCase; //机箱
    private String mousePad;   //鼠标垫
    private String other;  //其它配

    // Computer 自己充当 Director
    private Computer(ComputerBuilder builder) {
        this.mainBoard = builder.mainBoard;
        this.cpu = builder.cpu;
        this.hd = builder.hd;
        this.powerSupplier = builder.powerSupplier;
        this.graphicsCard = builder.graphicsCard;

        this.mouse = builder.mouse;
        this.computerCase = builder.computerCase;
        this.mousePad = builder.mousePad;
        this.other = builder.other;
    }

    // 声明一个静态内存类 Builder
    public static class ComputerBuilder {
        // 一个电脑的必须配置
        private String mainBoard;     // 主板
        private String cpu;           // cpu
        private String hd;            // 硬盘
        private String powerSupplier; // 电源
        private String graphicsCard;   // 显卡

        // 其它一些可选配置
        private String mouse; // 鼠标
        private String computerCase; //机箱
        private String mousePad;   //鼠标垫
        private String other;  //其它配件

        // 这里声明一些必须要传的参数「规定这些参数是必须传的，这里只是举例，再实中可能参数都是可选的」
        public ComputerBuilder() {
        }

        public ComputerBuilder setMainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this;
        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        // 其它的一些 setXXX() 方法

        // 生成最终的产品
        public Computer build() {
            return new Computer(this);
        }
    }
}

