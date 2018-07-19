/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.olympians;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ahill
 */
public class OlympicsWithSimpleAdvice {
    
    public static void main(String[] args) {
        ApplicationContext factoryOfChampions = new ClassPathXmlApplicationContext("advice-application-context.xml");
        Olympian nigel = factoryOfChampions.getBean("nigelTheExtremeCurler", Olympian.class);
        nigel.competeInEvent();
        
        Olympian jimbo = factoryOfChampions.getBean("cowTipperJimbo", Olympian.class);
        jimbo.competeInEvent();
        
        Olympian juan = factoryOfChampions.getBean("peruvianLlamaJouster", Olympian.class);
        juan.competeInEvent();
        
        juan.setEvent(null);
        juan.competeInEvent();
    }
    
}
