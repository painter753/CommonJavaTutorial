package com.lazyboyprod.howtodoinjava.try_with_resources;

public class TryWithResourcesResearch {

    public static void main(String[] args) {
        // old version
        ResourceConsumer rc = new ResourceConsumer();
        try {
            rc.open();
            rc.process();
        } finally {
            rc.close();
        }

        // new version
        try (ImprovedResourceConsumer irc = new ImprovedResourceConsumer()) {
            irc.open();
            irc.process();
        }
    }
}

class ResourceConsumer {

    public void open() {
        System.out.println("Take resource");
    }

    public void process() {
        System.out.println("Do some processes");
    }

    public void close() {
        System.out.println("Leave resource");
    }
}

class ImprovedResourceConsumer extends ResourceConsumer implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Leave resource for improved consumer");
    }
}
