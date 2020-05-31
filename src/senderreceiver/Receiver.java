package senderreceiver;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.BasicConfigurator;

public class Receiver {
	public static void main(String[] args) throws Exception{
		BasicConfigurator.configure();
		Properties settings=new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		Context ctx=new InitialContext(settings);
		Object obj =ctx.lookup("ConnectionFactory");
		ConnectionFactory factory=(ConnectionFactory) obj;
		Destination destination=(Destination) ctx.lookup("dynamicQueues/Tran Minh Tri");
		Connection con=factory.createConnection("admin","admin");
		con.start();
		Session session =con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageConsumer receiver=session.createConsumer(destination);
		System.out.println("Listed on queue...");
		receiver.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				try {
					if(message instanceof TextMessage) {
						TextMessage tm=(TextMessage) message;
						String txt=tm.getText();
						System.out.println(txt);
						message.acknowledge();
					}
					else if(message instanceof ObjectMessage) {
						ObjectMessage om=(ObjectMessage) message;
						System.out.println(om);
					}
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
