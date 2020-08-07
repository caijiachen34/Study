package com.kuang.demo01;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Proxy implements Rent{

    private Host host;


    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void fare(){
        System.out.println("中介收你中介费");
    }

    public void hetong(){
        System.out.println("中介带你签合同");
    }
}
