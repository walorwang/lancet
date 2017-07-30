package me.ele.lancet.testcase.insert;

import org.assertj.core.api.Assertions;

import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import me.ele.lancet.plugin.AOPBaseTest;

/**
 * Created by Jude on 2017/7/31.
 */

public class InsertCreateSuperTest extends AOPBaseTest{

    public static class HookClass{
        @TargetClass("com.sample.playground.SuperHeater")
        @Insert(value = "on",mayCreateSuper = true)
        public void on() {
            System.out.println("InsertCreateSuperTest");
            Origin.callVoid();
        }
    }

    @Override
    public void setUp() {
        super.setUp();
        addHookClass(HookClass.class);
    }

    @Override
    public void checkOutput(String output) {
        Assertions.assertThat(output)
                .contains("InsertCreateSuperTest");
    }
}
