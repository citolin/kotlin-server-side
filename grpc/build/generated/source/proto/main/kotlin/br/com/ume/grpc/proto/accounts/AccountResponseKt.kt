//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: accounts.proto

package br.com.ume.grpc.proto.accounts;

@kotlin.jvm.JvmSynthetic
public inline fun accountResponse(block: br.com.ume.grpc.proto.accounts.AccountResponseKt.Dsl.() -> kotlin.Unit): br.com.ume.grpc.proto.accounts.AccountResponse =
  br.com.ume.grpc.proto.accounts.AccountResponseKt.Dsl._create(br.com.ume.grpc.proto.accounts.AccountResponse.newBuilder()).apply { block() }._build()
public object AccountResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: br.com.ume.grpc.proto.accounts.AccountResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: br.com.ume.grpc.proto.accounts.AccountResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): br.com.ume.grpc.proto.accounts.AccountResponse = _builder.build()

    /**
     * <code>int64 id = 1;</code>
     */
    public var id: kotlin.Long
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * <code>int64 id = 1;</code>
     */
    public fun clearId() {
      _builder.clearId()
    }

    /**
     * <code>string name = 2;</code>
     */
    public var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <code>string name = 2;</code>
     */
    public fun clearName() {
      _builder.clearName()
    }

    /**
     * <code>string document = 3;</code>
     */
    public var document: kotlin.String
      @JvmName("getDocument")
      get() = _builder.getDocument()
      @JvmName("setDocument")
      set(value) {
        _builder.setDocument(value)
      }
    /**
     * <code>string document = 3;</code>
     */
    public fun clearDocument() {
      _builder.clearDocument()
    }

    /**
     * <code>double value = 4;</code>
     */
    public var value: kotlin.Double
      @JvmName("getValue")
      get() = _builder.getValue()
      @JvmName("setValue")
      set(value) {
        _builder.setValue(value)
      }
    /**
     * <code>double value = 4;</code>
     */
    public fun clearValue() {
      _builder.clearValue()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun br.com.ume.grpc.proto.accounts.AccountResponse.copy(block: br.com.ume.grpc.proto.accounts.AccountResponseKt.Dsl.() -> kotlin.Unit): br.com.ume.grpc.proto.accounts.AccountResponse =
  br.com.ume.grpc.proto.accounts.AccountResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()
