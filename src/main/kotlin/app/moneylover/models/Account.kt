package app.moneylover.models

class Account
(
    val id: UInt,
    var userName: String,
    var password: String,
)
{
    init
    {
        Account.currentAccountId = this.id.toInt();
    }

    companion object
    {
        @JvmStatic var currentAccountId: Int = -1;
    }
}