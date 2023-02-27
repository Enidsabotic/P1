public class MessageProducerInput {
    private Buffer <MessageProducer> producerBuffer = new Buffer<MessageProducer>();

    public MessageProducerInput(Buffer<MessageProducer> producerBuffer){
        this.producerBuffer = producerBuffer;
    }

    public void addMessageProducer(MessageProducer messageP){
       producerBuffer.put(messageP);
    }
}

