import handler.TestInboundHandler;
import handler.TestInboundHandlerTwo;
import handler.TestOutBoundHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ServerLauncher implements Launcher {

    private static final Integer port = 8081;

    public void init() {
        //
    }

    public void start() {
        //
    }

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(16);
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new TestOutBoundHandler());
                        ch.pipeline().addLast(new TestInboundHandler());
                        ch.pipeline().addLast(new TestInboundHandlerTwo());
                    }
                })
                .bind(port);
    }

}
