//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: accounts.proto

package br.com.ume.grpc.proto.accounts;

@kotlin.jvm.JvmSynthetic
public inline fun getAccountByDocumentRequest(block: br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequestKt.Dsl.() -> kotlin.Unit): br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest =
  br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequestKt.Dsl._create(br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.newBuilder()).apply { block() }._build()
public object GetAccountByDocumentRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest = _builder.build()

    /**
     * <code>string document = 1;</code>
     */
    public var document: kotlin.String
      @JvmName("getDocument")
      get() = _builder.getDocument()
      @JvmName("setDocument")
      set(value) {
        _builder.setDocument(value)
      }
    /**
     * <code>string document = 1;</code>
     */
    public fun clearDocument() {
      _builder.clearDocument()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest.copy(block: br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequestKt.Dsl.() -> kotlin.Unit): br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequest =
  br.com.ume.grpc.proto.accounts.GetAccountByDocumentRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()
