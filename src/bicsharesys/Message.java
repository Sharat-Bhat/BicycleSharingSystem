/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicsharesys;

/**
 *
 * @author sharat
 */
public class Message {
    String sender, text, receiver, reply, receiver_read, sender_read;
    
    public Message()
    {
        
    }
    public Message(String[] msg)
    {
        this.sender = msg[0];
        this.text = msg[1];
        this.receiver = msg[2];
        this.reply = msg[3];
        this.receiver_read = msg[4];
        this.sender_read = msg[5];
    }
}
