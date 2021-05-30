import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Time> createList(Time... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    private List<Integer> rez(Integer... elem){
        return new ArrayList<>(Arrays.asList(elem));
    }

    @Test
    void multipleChoice(){

        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(-5,10,3))));
        assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(30,13,20))));
        assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(40,-33,5))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));

        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(10,-8,7))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(25,76,9))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(20,40,-30))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(55210), SILab2.function(createList(new Time(25,40,20))));

        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(33,30,80))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(45,20,-10))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(86400), SILab2.function(createList(new Time(28,0,0))));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(28,15,10))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(28,11,4))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));
        exception = assertThrows(RuntimeException.class, () ->SILab2.function(createList(new Time(30,90,7))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));
    }

    @Test
    void everyBranch(){
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-5,30,55))));
        assertTrue(exception.getMessage().contains("The hours are smaller than the minimum"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(27,47,65))));
        assertTrue(exception.getMessage().contains("The hours are grater than the maximum"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(11,70,6))));
        assertTrue(exception.getMessage().contains("The minutes are not valid!"));

        assertEquals(rez(67810), SILab2.function(createList(new Time(15,63,15))));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(18,35,90))));
        assertTrue(exception.getMessage().contains("The seconds are not valid"));

        assertEquals(rez(86400), SILab2.function(createList(new Time(28,0,0))));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(28,40,10))));
        assertTrue(exception.getMessage().contains("The time is greater than the maximum"));

    }
}
