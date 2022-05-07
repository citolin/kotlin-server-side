package br.com.ume.grpc.proto.accounts

import br.com.ume.grpc.proto.accounts.AccountsGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for accounts.Accounts.
 */
object AccountsGrpcKt {
  const val SERVICE_NAME: String = AccountsGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = AccountsGrpc.getServiceDescriptor()

  val getAccountByIdMethod: MethodDescriptor<GetAccountByIdRequest, AccountResponse>
    @JvmStatic
    get() = AccountsGrpc.getGetAccountByIdMethod()

  val createAccountMethod: MethodDescriptor<CreateAccountRequest, AccountResponse>
    @JvmStatic
    get() = AccountsGrpc.getCreateAccountMethod()

  /**
   * A stub for issuing RPCs to a(n) accounts.Accounts service as suspending coroutines.
   */
  @StubFor(AccountsGrpc::class)
  class AccountsCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<AccountsCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): AccountsCoroutineStub =
        AccountsCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun getAccountById(request: GetAccountByIdRequest, headers: Metadata = Metadata()):
        AccountResponse = unaryRpc(
      channel,
      AccountsGrpc.getGetAccountByIdMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun createAccount(request: CreateAccountRequest, headers: Metadata = Metadata()):
        AccountResponse = unaryRpc(
      channel,
      AccountsGrpc.getCreateAccountMethod(),
      request,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the accounts.Accounts service based on Kotlin coroutines.
   */
  abstract class AccountsCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for accounts.Accounts.getAccountById.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun getAccountById(request: GetAccountByIdRequest): AccountResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method accounts.Accounts.getAccountById is unimplemented"))

    /**
     * Returns the response to an RPC for accounts.Accounts.createAccount.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun createAccount(request: CreateAccountRequest): AccountResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method accounts.Accounts.createAccount is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = AccountsGrpc.getGetAccountByIdMethod(),
      implementation = ::getAccountById
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = AccountsGrpc.getCreateAccountMethod(),
      implementation = ::createAccount
    )).build()
  }
}
