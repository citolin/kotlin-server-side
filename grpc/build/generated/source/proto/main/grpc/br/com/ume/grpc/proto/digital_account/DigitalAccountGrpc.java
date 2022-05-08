package br.com.ume.grpc.proto.digital_account;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: digital_account.proto")
public final class DigitalAccountGrpc {

  private DigitalAccountGrpc() {}

  public static final String SERVICE_NAME = "digital_account.DigitalAccount";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest,
      br.com.ume.grpc.proto.digital_account.DigitalAccountResponse> getCreateDigitalAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createDigitalAccount",
      requestType = br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest.class,
      responseType = br.com.ume.grpc.proto.digital_account.DigitalAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest,
      br.com.ume.grpc.proto.digital_account.DigitalAccountResponse> getCreateDigitalAccountMethod() {
    io.grpc.MethodDescriptor<br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest, br.com.ume.grpc.proto.digital_account.DigitalAccountResponse> getCreateDigitalAccountMethod;
    if ((getCreateDigitalAccountMethod = DigitalAccountGrpc.getCreateDigitalAccountMethod) == null) {
      synchronized (DigitalAccountGrpc.class) {
        if ((getCreateDigitalAccountMethod = DigitalAccountGrpc.getCreateDigitalAccountMethod) == null) {
          DigitalAccountGrpc.getCreateDigitalAccountMethod = getCreateDigitalAccountMethod =
              io.grpc.MethodDescriptor.<br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest, br.com.ume.grpc.proto.digital_account.DigitalAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createDigitalAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ume.grpc.proto.digital_account.DigitalAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DigitalAccountMethodDescriptorSupplier("createDigitalAccount"))
              .build();
        }
      }
    }
    return getCreateDigitalAccountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DigitalAccountStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DigitalAccountStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DigitalAccountStub>() {
        @java.lang.Override
        public DigitalAccountStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DigitalAccountStub(channel, callOptions);
        }
      };
    return DigitalAccountStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DigitalAccountBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DigitalAccountBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DigitalAccountBlockingStub>() {
        @java.lang.Override
        public DigitalAccountBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DigitalAccountBlockingStub(channel, callOptions);
        }
      };
    return DigitalAccountBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DigitalAccountFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DigitalAccountFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DigitalAccountFutureStub>() {
        @java.lang.Override
        public DigitalAccountFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DigitalAccountFutureStub(channel, callOptions);
        }
      };
    return DigitalAccountFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DigitalAccountImplBase implements io.grpc.BindableService {

    /**
     */
    public void createDigitalAccount(br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest request,
        io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.digital_account.DigitalAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDigitalAccountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateDigitalAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest,
                br.com.ume.grpc.proto.digital_account.DigitalAccountResponse>(
                  this, METHODID_CREATE_DIGITAL_ACCOUNT)))
          .build();
    }
  }

  /**
   */
  public static final class DigitalAccountStub extends io.grpc.stub.AbstractAsyncStub<DigitalAccountStub> {
    private DigitalAccountStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DigitalAccountStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DigitalAccountStub(channel, callOptions);
    }

    /**
     */
    public void createDigitalAccount(br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest request,
        io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.digital_account.DigitalAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDigitalAccountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DigitalAccountBlockingStub extends io.grpc.stub.AbstractBlockingStub<DigitalAccountBlockingStub> {
    private DigitalAccountBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DigitalAccountBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DigitalAccountBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.ume.grpc.proto.digital_account.DigitalAccountResponse createDigitalAccount(br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDigitalAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DigitalAccountFutureStub extends io.grpc.stub.AbstractFutureStub<DigitalAccountFutureStub> {
    private DigitalAccountFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DigitalAccountFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DigitalAccountFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ume.grpc.proto.digital_account.DigitalAccountResponse> createDigitalAccount(
        br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDigitalAccountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DIGITAL_ACCOUNT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DigitalAccountImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DigitalAccountImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DIGITAL_ACCOUNT:
          serviceImpl.createDigitalAccount((br.com.ume.grpc.proto.digital_account.CreateDigitalAccountRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.digital_account.DigitalAccountResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DigitalAccountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DigitalAccountBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.ume.grpc.proto.digital_account.DigitalAccountProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DigitalAccount");
    }
  }

  private static final class DigitalAccountFileDescriptorSupplier
      extends DigitalAccountBaseDescriptorSupplier {
    DigitalAccountFileDescriptorSupplier() {}
  }

  private static final class DigitalAccountMethodDescriptorSupplier
      extends DigitalAccountBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DigitalAccountMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DigitalAccountGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DigitalAccountFileDescriptorSupplier())
              .addMethod(getCreateDigitalAccountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
