package org.example.firstspringproject;
import org.springframework.stereotype.Service;

@Service("ForAnnotationMethod")
public class ForAnnotationMethod {

    @TimeMonitor
    public String doSomething() {
        for(int i=0; i<1000000000; i++){}
        return "something";
    }  // join point
}
