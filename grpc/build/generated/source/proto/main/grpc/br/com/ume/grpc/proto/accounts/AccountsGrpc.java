package br.com.ume.grpc.proto.accounts;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: accounts.proto")
public final class AccountsGrpc {

  private AccountsGrpc() {}

  public static final String SERVICE_NAME = "accounts.Accounts";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.ume.grpc.proto.accounts.GetAccountByIdRequest,
      br.com.ume.grpc.proto.accounts.AccountResponse> getGetAccountByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAccountById",
      requestType = br.com.ume.grpc.proto.accounts.GetAccountByIdRequest.class,
      responseType = br.com.ume.grpc.proto.accounts.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ume.grpc.proto.accounts.GetAccountByIdRequest,
      br.com.ume.grpc.proto.accounts.AccountResponse> getGetAccountByIdMethod() {
    io.grpc.MethodDescriptor<br.com.ume.grpc.proto.accounts.GetAccountByIdRequest, br.com.ume.grpc.proto.accounts.AccountResponse> getGetAccountByIdMethod;
    if ((getGetAccountByIdMethod = AccountsGrpc.getGetAccountByIdMethod) == null) {
      synchronized (AccountsGrpc.class) {
        if ((getGetAccountByIdMethod = AccountsGrpc.getGetAccountByIdMethod) == null) {
          AccountsGrpc.getGetAccountByIdMethod = getGetAccountByIdMethod =
              io.grpc.MethodDescriptor.<br.com.ume.grpc.proto.accounts.GetAccountByIdRequest, br.com.ume.grpc.proto.accounts.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAccountById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ume.grpc.proto.accounts.GetAccountByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ume.grpc.proto.accounts.AccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountsMethodDescriptorSupplier("getAccountById"))
              .build();
        }
      }
    }
    return getGetAccountByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.com.ume.grpc.proto.accounts.CreateAccountRequest,
      br.com.ume.grpc.proto.accounts.AccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createAccount",
      requestType = br.com.ume.grpc.proto.accounts.CreateAccountRequest.class,
      responseType = br.com.ume.grpc.proto.accounts.AccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.ume.grpc.proto.accounts.CreateAccountRequest,
      br.com.ume.grpc.proto.accounts.AccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<br.com.ume.grpc.proto.accounts.CreateAccountRequest, br.com.ume.grpc.proto.accounts.AccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = AccountsGrpc.getCreateAccountMethod) == null) {
      synchronized (AccountsGrpc.class) {
        if ((getCreateAccountMethod = AccountsGrpc.getCreateAccountMethod) == null) {
          AccountsGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<br.com.ume.grpc.proto.accounts.CreateAccountRequest, br.com.ume.grpc.proto.accounts.AccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ume.grpc.proto.accounts.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.ume.grpc.proto.accounts.AccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountsMethodDescriptorSupplier("createAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountsStub>() {
        @java.lang.Override
        public AccountsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountsStub(channel, callOptions);
        }
      };
    return AccountsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountsBlockingStub>() {
        @java.lang.Override
        public AccountsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountsBlockingStub(channel, callOptions);
        }
      };
    return AccountsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountsFutureStub>() {
        @java.lang.Override
        public AccountsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountsFutureStub(channel, callOptions);
        }
      };
    return AccountsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AccountsImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAccountById(br.com.ume.grpc.proto.accounts.GetAccountByIdRequest request,
        io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.accounts.AccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountByIdMethod(), responseObserver);
    }

    /**
     */
    public void createAccount(br.com.ume.grpc.proto.accounts.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.accounts.AccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAccountByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.ume.grpc.proto.accounts.GetAccountByIdRequest,
                br.com.ume.grpc.proto.accounts.AccountResponse>(
                  this, METHODID_GET_ACCOUNT_BY_ID)))
          .addMethod(
            getCreateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.ume.grpc.proto.accounts.CreateAccountRequest,
                br.com.ume.grpc.proto.accounts.AccountResponse>(
                  this, METHODID_CREATE_ACCOUNT)))
          .build();
    }
  }

  /**
   */
  public static final class AccountsStub extends io.grpc.stub.AbstractAsyncStub<AccountsStub> {
    private AccountsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountsStub(channel, callOptions);
    }

    /**
     */
    public void getAccountById(br.com.ume.grpc.proto.accounts.GetAccountByIdRequest request,
        io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.accounts.AccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createAccount(br.com.ume.grpc.proto.accounts.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.accounts.AccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccountsBlockingStub extends io.grpc.stub.AbstractBlockingStub<AccountsBlockingStub> {
    private AccountsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountsBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.ume.grpc.proto.accounts.AccountResponse getAccountById(br.com.ume.grpc.proto.accounts.GetAccountByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.ume.grpc.proto.accounts.AccountResponse createAccount(br.com.ume.grpc.proto.accounts.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccountsFutureStub extends io.grpc.stub.AbstractFutureStub<AccountsFutureStub> {
    private AccountsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ume.grpc.proto.accounts.AccountResponse> getAccountById(
        br.com.ume.grpc.proto.accounts.GetAccountByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.ume.grpc.proto.accounts.AccountResponse> createAccount(
        br.com.ume.grpc.proto.accounts.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_BY_ID = 0;
  private static final int METHODID_CREATE_ACCOUNT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT_BY_ID:
          serviceImpl.getAccountById((br.com.ume.grpc.proto.accounts.GetAccountByIdRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.accounts.AccountResponse>) responseObserver);
          break;
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((br.com.ume.grpc.proto.accounts.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<br.com.ume.grpc.proto.accounts.AccountResponse>) responseObserver);
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

  private static abstract class AccountsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.ume.grpc.proto.accounts.AccountsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Accounts");
    }
  }

  private static final class AccountsFileDescriptorSupplier
      extends AccountsBaseDescriptorSupplier {
    AccountsFileDescriptorSupplier() {}
  }

  private static final class AccountsMethodDescriptorSupplier
      extends AccountsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountsMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccountsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountsFileDescriptorSupplier())
              .addMethod(getGetAccountByIdMethod())
              .addMethod(getCreateAccountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
