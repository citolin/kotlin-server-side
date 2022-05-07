//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: accounts.proto

package accounts;

@kotlin.jvm.JvmSynthetic
public inline fun accountResponse(block: accounts.AccountResponseKt.Dsl.() -> kotlin.Unit): accounts.AccountResponse =
  accounts.AccountResponseKt.Dsl._create(accounts.AccountResponse.newBuilder()).apply { block() }._build()
public object AccountResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: accounts.AccountResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: accounts.AccountResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): accounts.AccountResponse = _builder.build()

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
public inline fun accounts.AccountResponse.copy(block: accounts.AccountResponseKt.Dsl.() -> kotlin.Unit): accounts.AccountResponse =
  accounts.AccountResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()