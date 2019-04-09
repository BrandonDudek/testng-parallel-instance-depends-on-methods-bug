# testng-parallel-instance-depends-on-methods-bug
This Sample Projects shows that there is a bug in TestNG, when you have Parallel Instances that use `dependsOnMethod`.
The bug is that the Test Methods run out of order.
 
 **See:** [Depends On Methods is not fully enforced when running Parallel Instances #2054](https://github.com/cbeust/testng/issues/2054)