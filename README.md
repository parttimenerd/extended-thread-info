Extended Thread Info
====================

This small project contains the class [ExtendedThreadInfo](src/main/java/me/bechberger/ExtendedThreadInfo.java), 
uses the `jstack` binary that comes with your JVM to map
the Java thread id to

- the thread name
- the OS thread id
- the OS thread priority
- the CPU and user CPU time

Do we have to use `jstack`? Yes, because parsing the emitted thread dumps
is the only way to get the OS thread id.

Was it my original idea? No, others proposed it before (e.g. [here](https://stackoverflow.com/a/26550955/19040822)).

Is it fast? On my system each call to `ExtendedThreadInfo#getAll()` takes about 70ms on my machine.

License
=======
MIT