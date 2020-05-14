package com.chl.websocket;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

/**
 * 这里是官网的客户端例子，
 * 利用awt组件做了一个聊天界面，可以开启、关闭webSocket连接。也可以接收其他端或服务端的消息并展示
 * 为了创建Websocket连接，需要通过浏览器发出请求，之后服务器进行回应，这个过程通常称为“握手”（handshaking
 * @author chenhailong
 *
 */
public class WebSocketClientAWT extends JFrame implements ActionListener {
	private static final long serialVersionUID = -6056260699202978657L;

	private final JTextField uriField;
	private final JButton connect;
	private final JButton close;
	private final JTextArea ta;
	private final JTextField chatField;
	@SuppressWarnings("rawtypes")
	private final JComboBox draft;
	private WebSocketClient cc;

	/**
	 * 利用AWT组件构建一个聊天界面
	 * @param defaultlocation
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WebSocketClientAWT( String defaultlocation ) {
		super( "WebSocket 聊天客户端" );
		Container c = getContentPane();
		GridLayout layout = new GridLayout();
		layout.setColumns( 1 );
		layout.setRows( 6 );
		c.setLayout( layout );

		Draft[] drafts = { new Draft_6455() };
		draft = new JComboBox( drafts );
		c.add( draft );

		uriField = new JTextField();
		uriField.setText( defaultlocation );
		c.add( uriField );

		connect = new JButton( "建立连接!" );
		connect.addActionListener( this );
		c.add( connect );

		close = new JButton( "关闭连接!" );
		close.addActionListener( this );
		close.setEnabled( false );
		c.add( close );

		JScrollPane scroll = new JScrollPane();
		ta = new JTextArea();
		scroll.setViewportView( ta );
		c.add( scroll );

		chatField = new JTextField();
		chatField.setText( "" );
		chatField.addActionListener( this );
		c.add( chatField );

		java.awt.Dimension d = new java.awt.Dimension( 300, 400 );
		setPreferredSize( d );
		setSize( d );

		addWindowListener( new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing( WindowEvent e ) {
				if( cc != null ) {
					cc.close();
				}
				dispose();
			}
		} );

		setLocationRelativeTo( null );
		setVisible( true );
	}

	/**
	 * 事件监听
	 */
	public void actionPerformed( ActionEvent e ) {

		if( e.getSource() == chatField ) {
			if( cc != null ) {
				cc.send( chatField.getText() );
				chatField.setText( "" );
				chatField.requestFocus();
			}

		} else if( e.getSource() == connect ) {
			try {
				// cc = new ChatClient(new URI(uriField.getText()), area, ( Draft ) draft.getSelectedItem() );
				cc = new WebSocketClient( new URI( uriField.getText() ), (Draft) draft.getSelectedItem() ) {

					@Override
					public void onMessage( String message ) {
						ta.append( "got: " + message + "\n" );
						ta.setCaretPosition( ta.getDocument().getLength() );
					}

					@Override
					public void onOpen( ServerHandshake handshake ) {
						ta.append( "You are connected to ChatServer: " + getURI() + "\n" );
						ta.setCaretPosition( ta.getDocument().getLength() );
					}

					@Override
					public void onClose( int code, String reason, boolean remote ) {
						ta.append( "You have been disconnected from: " + getURI() + "; Code: " + code + " " + reason + "\n" );
						ta.setCaretPosition( ta.getDocument().getLength() );
						connect.setEnabled( true );
						uriField.setEditable( true );
						draft.setEditable( true );
						close.setEnabled( false );
					}

					@Override
					public void onError( Exception ex ) {
						ta.append( "Exception occured ...\n" + ex + "\n" );
						ta.setCaretPosition( ta.getDocument().getLength() );
						ex.printStackTrace();
						connect.setEnabled( true );
						uriField.setEditable( true );
						draft.setEditable( true );
						close.setEnabled( false );
					}
				};

				close.setEnabled( true );
				connect.setEnabled( false );
				uriField.setEditable( false );
				draft.setEditable( false );
				cc.connect();
			} catch ( URISyntaxException ex ) {
				ta.append( uriField.getText() + " is not a valid WebSocket URI\n" );
			}
		} else if( e.getSource() == close ) {
			cc.close();
		}
	}

	public static void main( String[] args ) {
		String location;
		if( args.length != 0 ) { //有参是取这里
			location = args[ 0 ];
			System.out.println( "默认的服务端url为: \'" + location + "\'" );
		} else {
			location = "ws://localhost:9999";
			System.out.println( "默认的服务端url为:  \'" + location + "\'" );
		}
		new WebSocketClientAWT( location );
	}

}